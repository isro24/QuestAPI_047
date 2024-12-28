package com.example.praktikum8

import android.app.Application
import com.example.praktikum8.dependenciesinjection.AppContainer
import com.example.praktikum8.dependenciesinjection.MahasiswaContainer
import com.example.praktikum8.model.Mahasiswa

class MahasiswaApplications:Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=MahasiswaContainer()
    }
}