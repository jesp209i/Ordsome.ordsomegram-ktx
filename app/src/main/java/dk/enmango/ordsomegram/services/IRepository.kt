package dk.enmango.ordsomegram.services

import dk.enmango.ordsomegram.model.IEntity

interface IRepository<T: IEntity> {
    fun add(entity: T)
    fun findNextNumber() : Int
    fun getAll() : MutableList<T>
    fun findById(id: String) : T?
    fun update(entity: T)
}