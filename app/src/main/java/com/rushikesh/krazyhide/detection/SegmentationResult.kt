package com.rushikesh.krazyhide.detection

data class RawSegmentation(
    @JvmField val box: DetectionBox,
    @JvmField val mask: BooleanArray,
    @JvmField val maskWidth: Int,
    @JvmField val maskHeight: Int
)
