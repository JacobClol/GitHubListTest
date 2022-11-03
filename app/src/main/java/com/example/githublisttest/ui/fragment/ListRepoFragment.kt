package com.example.githublisttest.ui.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.githublisttest.databinding.FragmentListRepoBinding
import com.example.githublisttest.domain.models.RepoGit
import com.example.githublisttest.ui.adapter.ListReposAdapter
import com.example.githublisttest.ui.viewmodel.ListRepoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListRepoFragment : Fragment(), ListReposAdapter.OnRepoClickListener {

    private val listRepoViewModel: ListRepoViewModel by viewModels()

    private var _binding: FragmentListRepoBinding? = null
    private val binding get() = _binding!!

    private val listRepos: ArrayList<RepoGit> = ArrayList()
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private val adapter by lazy {
        ListReposAdapter(requireContext(), listRepos, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListRepoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupSwipeRefreshLayout()

        listRepoViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
        listRepoViewModel.listRepo.observe(viewLifecycleOwner) {
            listRepos.clear()
            listRepos.addAll(it)
            adapter.notifyDataSetChanged()
            if (swipeRefreshLayout.isRefreshing) {
                swipeRefreshLayout.isRefreshing = false
            }
        }
        listRepoViewModel.error.observe(viewLifecycleOwner) {
            it?.let { errorMsg ->
                Toast.makeText(requireContext(), errorMsg, Toast.LENGTH_SHORT).show()
            }
            if (swipeRefreshLayout.isRefreshing) {
                swipeRefreshLayout.isRefreshing = false
            }
        }
        listRepoViewModel.getRepos()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onRepoClick(repo: RepoGit) {
        val action = ListRepoFragmentDirections.actionFirstFragmentToSecondFragment(repo)
        findNavController().navigate(action)
    }

    private fun setupSwipeRefreshLayout() {
        swipeRefreshLayout = binding.swipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            listRepoViewModel.getRepos()
        }
    }

    private fun setupRecyclerView() {
        if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.rvListRepos.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            binding.rvListRepos.layoutManager = GridLayoutManager(requireContext(), 4)
        }
        binding.rvListRepos.itemAnimator = DefaultItemAnimator()
        binding.rvListRepos.adapter = adapter
    }
}