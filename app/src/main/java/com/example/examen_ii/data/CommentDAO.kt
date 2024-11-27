package com.example.examen_ii.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.examen_ii.entity.CommentEntity

@Dao
interface CommentDAO {
    @Insert
    suspend fun insertComment(comment: CommentEntity)

    @Query("SELECT * FROM comment WHERE postId = :postId")
    suspend fun getCommentsForPost(postId: Int): List<CommentEntity>

    @Query("SELECT * FROM comment WHERE id = :id")
    suspend fun getCommentById(id: Int): CommentEntity?
}