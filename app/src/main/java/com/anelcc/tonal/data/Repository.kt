package com.anelcc.tonal.data

import android.content.Context
import android.util.Log
import com.anelcc.tonal.R
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import javax.inject.Inject

class Repository @Inject constructor(private val moshi: Moshi, @ApplicationContext private val context: Context) {

    fun fetchData(): List<Movement> {
        val jsonString: String
        try {
            jsonString = context.resources.openRawResource(R.raw.movement).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
           Log.e("Repository", "Error reading movement.json", ioException)
            return emptyList()
        }

        val listType = Types.newParameterizedType(List::class.java, Movement::class.java)
        val adapter: JsonAdapter<List<Movement>> = moshi.adapter(listType)

        Log.e("Repository", "Error reading movement.json")
        return adapter.fromJson(jsonString) ?: emptyList()
    }
}
