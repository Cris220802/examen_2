package com.example.examen_ii.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.examen_ii.entity.PostEntity

@Dao
interface PostDAO {
    @Insert
    suspend fun insertPost(post: PostEntity)

    @Query("SELECT * FROM post")
    suspend fun getAllPosts(): List<PostEntity>

    @Query("SELECT * FROM post WHERE id = :postId")
    suspend fun getPostById(postId: Int): PostEntity?

}