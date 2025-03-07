package com.jmendozat13.checkinapp.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LocalDataStore @Inject constructor(private val dataStore: DataStore<Preferences>) {

    companion object {
        const val PREFERENCES_SHOW_ONBOARDING_CODE = "show_onboarding"
    }

    private val showOnboarding = booleanPreferencesKey(PREFERENCES_SHOW_ONBOARDING_CODE)

    suspend fun getIsShowOnboarding(): Boolean {
        return dataStore.data.first()[showOnboarding] ?: false
    }

    suspend fun setShowOnboarding() {
        dataStore.edit { preferences ->
            preferences[showOnboarding] = true
        }

    }


}