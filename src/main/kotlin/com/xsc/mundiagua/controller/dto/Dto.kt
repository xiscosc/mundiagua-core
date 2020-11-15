package com.xsc.mundiagua.controller.dto

abstract class Dto<M> {

    private val mapper = Mapper<Dto<M>, M>()

    fun partialUpdate(model: M) = mapper.partialUpdate(this, model)
}