package com.example.gyannproject.signUpscreens

interface DrawableClickListener {
    enum class DrawablePosition { TOP, BOTTOM, START, END }
    fun onClick(target: DrawablePosition)
}
