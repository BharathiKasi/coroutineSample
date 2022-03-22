package com.example.coroutinesample.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(){
    println("Main Thread name is ${Thread.currentThread().name}")

    //Step 1:
    //creating background thread or worker thread...
  /*  thread {
        println("Running under background thread ${Thread.currentThread().name}")
        Thread.sleep(1000)   // it will stop the whole application for 1 seconda
        println("Finishing under background thread ${Thread.currentThread().name}")
    }*/


    /**
     *   By default the application wait for background thread to complete its task. Once the all the background thread complete its
    task then only application exit.

    But in Coroutine, application will never wait by default for coroutine background task to complete. So we manually make
    application to wait until the  coroutine task complete.
     */
    //Step 2:
    //Creating Coroutine
    GlobalScope.launch {// it will create new coroutine and it won't block the main or current thread.
        println("Running under background thread ${Thread.currentThread().name}")
        mySuspendFunction(1000) // it will only the current coroutine and not whole application.
        println("Finishing under background thread ${Thread.currentThread().name}")
    }
    runBlocking { //this will create new coroutine but it will block the main or current threa.
        mySuspendFunction(2000)    //so this is not the practical way to wait for coroutine.
    }
    println("Finishing Main thread name is ${Thread.currentThread().name}")
}

suspend fun mySuspendFunction(time:Long){
    delay(time)
}