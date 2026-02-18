package com.anelcc.tonal.domain

import com.anelcc.tonal.data.Movement
import com.anelcc.tonal.data.Repository
import javax.inject.Inject

class MoventUseCase @Inject constructor(val repository: Repository) {

   operator fun invoke(): MutableList<Movement> {
        return repository.fetchData() as MutableList<Movement>
    }
}