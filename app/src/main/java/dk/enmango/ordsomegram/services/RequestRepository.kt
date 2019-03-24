package dk.enmango.ordsomegram.services

import dk.enmango.ordsomegram.model.IEntity
import dk.enmango.ordsomegram.model.Request

abstract class RequestRepository<Request> : IRepository<IEntity>{
    companion object {
        var requests = mutableListOf<IEntity>()
    }

    override fun add(entity: IEntity){
        entity.id = findNextNumber().toString()
        requests.add(entity)
    }
    override fun findNextNumber() : Int {
        return requests.size
    }
    override fun getAll() : MutableList<IEntity> {
        return requests
    }
    override fun findById(id: String) : IEntity? {
        val request = requests.find{ request -> request.id == id }
        return request
    }
}

