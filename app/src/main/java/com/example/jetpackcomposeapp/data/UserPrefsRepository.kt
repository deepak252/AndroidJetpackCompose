package com.example.jetpackcomposeapp.data

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPrefsRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    private object PreferencesKey{
        val userToken  = stringPreferencesKey("user_token")
    }

    suspend fun setToken(token: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.userToken] = token
        }
    }

    val getToken : Flow<String> = dataStore.data
        .catch {
            if(this is Exception){
                Log.d("MyTag", "getToken Exception : ${this.message}")
                emit(emptyPreferences())
            }
        }.map { preference->
            preference[PreferencesKey.userToken ] ?: "NA"
        }
}