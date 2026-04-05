package com.rushikesh.krazyhide.detection

data class DetectionBox(
    @JvmField val x1: Float,
    @JvmField val y1: Float,
    @JvmField val x2: Float,
    @JvmField val y2: Float,
    @JvmField val confidence: Float
)