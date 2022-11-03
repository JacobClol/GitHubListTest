package com.example.githublisttest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.githublisttest.R
import com.example.githublisttest.databinding.FragmentDetailRepoBinding
import com.example.githublisttest.domain.models.RepoGit
import com.example.githublisttest.ui.viewmodel.DetailRepoViewModel
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailRepoFragment : Fragment(), AppBarLayout.OnOffsetChangedListener {

    private val detailRepoViewModel: DetailRepoViewModel by viewModels()

    private var _binding: FragmentDetailRepoBinding? = null
    private val binding get() = _binding!!

    private var isShow = false
    private var scrollRange = -1

    val argsRepo: DetailRepoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailRepoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailRepoViewModel.repoDetail.observe(viewLifecycleOwner){
            setValues(it)
        }
        detailRepoViewModel.repoError.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
        detailRepoViewModel.setDetail(argsRepo.repo)
    }

    private fun setValues(repoGit: RepoGit?) {
        with(binding){
            txName.text = repoGit?.name
            txFullName.text = repoGit?.fullName
            txDescription.text = repoGit?.description
            txLanguage.text = repoGit?.language
            txCreatedAt.text = repoGit?.createdAt
            txUpdatedAt.text = repoGit?.updatedAt
            txHtmUrl.text = repoGit?.htmlUrl
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (scrollRange == -1) {
            scrollRange = appBarLayout?.totalScrollRange ?: -1
        }
        if (scrollRange + verticalOffset == 0) {
            binding.collapsingToolbar.title = getString(R.string.app_name)
            isShow = true
        } else {
            binding.collapsingToolbar.title = " "
            isShow = false
        }
    }
}