package com.example.touristsights

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SightAdapter(
    // jsonデータ内のimageNameと同じ名前の画像をリソースから取得する処理で使う
    private val context: Context,
    // jsonデータをデコードしたSightクラスの配列
    private val sights: List<Sight>
): RecyclerView.Adapter<SightAdapter.ViewHolder>() {

    // セルに使用するビューを保持
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val image: ImageView = view.findViewById(R.id.image)
        val description: TextView = view.findViewById(R.id.description)
        val kind: TextView = view.findViewById(R.id.kind)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // card_layout.xmlをセルとして使うのでR.layout.card_layoutでviewを作成
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    // セルにデータを設定する時に呼ばれる
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = sights[position].name
        holder.description.text = sights[position].description
        holder.kind.text = sights[position].kind
        var imageResource = context.resources.getIdentifier(
            sights[position].imageName,
            "drawable", context.packageName
        )
        holder.image.setImageResource(imageResource)
    }

    override fun getItemCount(): Int = sights.size
}