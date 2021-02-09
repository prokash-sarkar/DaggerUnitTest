package com.example.dagger

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

/**
 * A custom [AndroidJUnitRunner] used to replace the application used in tests with a
 * [TestBaseApplication].
 */
class CustomTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, TestBaseApplication::class.java.name, context)
    }

}