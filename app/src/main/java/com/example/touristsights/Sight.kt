package com.example.touristsights

import android.content.res.Resources
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.parse
import java.io.BufferedReader
import java.io.InputStreamReader

// @Serializableを付けると、デコード・エンコードできる
@Serializable
class Sight (
    val name: String,
    val imageName: String,
    val description: String,
    val kind: String
)

fun getSights(resources: Resources): List<Sight> {
    val assetManager = resources.assets
    // assetのjsonファイルを開いてデータを取得する
    val inputStream = assetManager.open("sights.json")
    // データ取り出し
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val str: String = bufferedReader.readText()
    // 取得したjsonをSightクラスに変換
    val obj = Json { allowStructuredMapKeys = true }.decodeFromString(ListSerializer(Sight.serializer()), str)
    return obj
}