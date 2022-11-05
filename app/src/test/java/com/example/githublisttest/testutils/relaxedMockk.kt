package com.example.githublisttest.testutils

import kotlin.reflect.KClass
import io.mockk.MockK
import io.mockk.MockKDsl

inline fun <reified T : Any> relaxedMockk(
    name: String? = null,
    vararg moreInterface: KClass<*>,
    block: T.() -> Unit = {}
): T = MockK.useImpl {
    MockKDsl.internalMockk(
        name,
        true,
        *moreInterface,
        relaxUnitFun = true,
        block = block
    )
}