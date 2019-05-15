package com.blackbeared.baseproject.app.extensions

import org.koin.standalone.StandAloneContext

interface DIComponent

/**
 * inject lazily given dependency
 *
 * @param name - bean name / optional
 */
inline fun <reified T : Any> DIComponent.inject(name: String = "") =
    lazy { StandAloneContext.getKoin().koinContext.get<T>(name) }

inline fun <reified T : Any> DIComponent.get(name: String = "") = StandAloneContext.getKoin().koinContext.get<T>(name)