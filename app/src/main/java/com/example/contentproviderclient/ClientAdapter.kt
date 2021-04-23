package com.example.contentproviderclient

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ClientAdapter (private val mCursor: Cursor): RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.client_item, parent, false)
        return ClientViewHolder(view)
    }

    override fun getItemCount(): Int = mCursor.count

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.bindData(mCursor)
    }

    class ClientViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val clientTitle = itemView.findViewById<TextView>(R.id.tv_client_item_title)
        val clientDescription = itemView.findViewById<TextView>(R.id.tv_client_item_description)

        fun bindData(cursor: Cursor){
            val title = cursor.getString(cursor.getColumnIndex("title"))
            val description =cursor.getString(cursor.getColumnIndex("description"))

            clientTitle.text = title
            clientDescription.text = description
        }

    }
}
