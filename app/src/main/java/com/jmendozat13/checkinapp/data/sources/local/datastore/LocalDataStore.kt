package com.jmendozat13.checkinapp.data.sources.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LocalDataStore @Inject constructor(private val dataStore: DataStore<Preferences>) {

    companion object {
        const val PREFERENCES_SHOW_ONBOARDING_CODE = "show_onboarding"
        const val PREFERENCES_USER_LOGIN_CODE = "user_login"
    }

    private val showOnboarding = booleanPreferencesKey(PREFERENCES_SHOW_ONBOARDING_CODE)
    private val userLogin = booleanPreferencesKey(PREFERENCES_USER_LOGIN_CODE)

    suspend fun getIsShowOnboarding(): Boolean {
        return dataStore.data.first()[showOnboarding] ?: false
    }

    suspend fun setShowOnboarding() {
        dataStore.edit { preferences ->
            preferences[showOnboarding] = true
        }
    }

    suspend fun getIsUserLogin(): Boolean {
        return dataStore.data.first()[userLogin] ?: false
    }

    suspend fun setUserLogin() {
        dataStore.edit { preferences ->
            preferences[userLogin] = true
        }
    }


}