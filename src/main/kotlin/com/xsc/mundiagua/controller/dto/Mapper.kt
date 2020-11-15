package com.xsc.mundiagua.controller.dto

import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.findParameterByName
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

class Mapper<D, M> {
    fun partialUpdate(dto: D, currentModel: M): M {
        val modelProps = currentModel!!::class.memberProperties.associateBy(KProperty<*>::name) as Map<String, KProperty1<M, *>>
        val dtoProps = dto!!::class.memberProperties.associateBy(KProperty<*>::name) as Map<String, KProperty1<D, *>>
        val constructor = currentModel!!::class.primaryConstructor
        val params = modelProps.map {
            val key = constructor!!.findParameterByName(it.key)!!
            if (dtoProps.containsKey(it.key)) {
                val dtoV = dtoProps[it.key]?.get(dto)
                key to if (dtoV !== null) dtoV else it.value.get(currentModel)
            } else {
                key to it.value.get(currentModel)
            }
        }.toMap()
        return constructor?.callBy(params)!!
    }
}