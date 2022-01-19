package com.example.touristsights

import kotlinx.serialization.Serializable

// @Serializableを付けると、デコード・エンコードできる
@Serializable
class Sight (
    val name: String,
    val imageName: String,
    val description: String,
    val kind: String
)