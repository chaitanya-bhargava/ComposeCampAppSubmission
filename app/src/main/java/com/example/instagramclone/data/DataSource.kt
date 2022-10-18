package com.example.instagramclone.data


import com.example.instagramclone.R
import com.example.instagramclone.model.Message
import com.example.instagramclone.model.Post
import com.example.instagramclone.model.ProfilePost
import com.example.instagramclone.model.Story

class Datasource {
    fun loadPosts(): List<Post> {
        return listOf(
            Post(R.string.user1, R.drawable.image2),
            Post(R.string.user2, R.drawable.image1),
            Post(R.string.user3, R.drawable.image3),
            Post(R.string.user4, R.drawable.image4),
            Post(R.string.user5, R.drawable.image5),
            Post(R.string.user6, R.drawable.image6),
            Post(R.string.user7, R.drawable.image7),
            Post(R.string.user8, R.drawable.image8),
            Post(R.string.user9, R.drawable.image9),
            Post(R.string.user10, R.drawable.image10))
    }
    fun loadMessages(): List<Message> {
        return listOf(
            Message(R.string.user1,R.string.msg1,R.drawable.image2),
            Message(R.string.user2,R.string.msg2,R.drawable.image1),
            Message(R.string.user3,R.string.msg3,R.drawable.image3),
            Message(R.string.user4,R.string.msg4,R.drawable.image4),
            Message(R.string.user5,R.string.msg5,R.drawable.image5),
            Message(R.string.user6,R.string.msg6,R.drawable.image6),
            Message(R.string.user7,R.string.msg7,R.drawable.image7),
            Message(R.string.user8,R.string.msg8,R.drawable.image8),
            Message(R.string.user9,R.string.msg9,R.drawable.image9),
            Message(R.string.user10,R.string.msg10,R.drawable.image10)
            )
    }
    fun loadImages(): List<ProfilePost> {
        return listOf(
            ProfilePost(R.drawable.post1),
            ProfilePost(R.drawable.post2),
            ProfilePost(R.drawable.post3),
            ProfilePost(R.drawable.post4),
            ProfilePost(R.drawable.post5),
            ProfilePost(R.drawable.post6),
            ProfilePost(R.drawable.post7),
            ProfilePost(R.drawable.post8),
            ProfilePost(R.drawable.post9),
            ProfilePost(R.drawable.post10),
            ProfilePost(R.drawable.post11),
            ProfilePost(R.drawable.post12)
        )
    }
    fun loadStories(): List<Story> {
        return listOf(
            Story(R.string.user1, R.drawable.image2),
            Story(R.string.user2, R.drawable.image1),
            Story(R.string.user3, R.drawable.image3),
            Story(R.string.user4, R.drawable.image4),
            Story(R.string.user5, R.drawable.image5),
            Story(R.string.user6, R.drawable.image6),
            Story(R.string.user7, R.drawable.image7),
            Story(R.string.user8, R.drawable.image8),
            Story(R.string.user9, R.drawable.image9),
            Story(R.string.user10, R.drawable.image10)
        )
    }
    fun loadStoryHighlights(): List<Story> {
        return listOf(
            Story(R.string.story1, R.drawable.post1),
            Story(R.string.story2, R.drawable.image1),
            Story(R.string.story3, R.drawable.image3),
            Story(R.string.story4, R.drawable.image4),
            Story(R.string.story5, R.drawable.image5),
            Story(R.string.story6, R.drawable.image6),
            Story(R.string.story7, R.drawable.image7),
            Story(R.string.story8, R.drawable.image8),
            Story(R.string.story9, R.drawable.image9),
            Story(R.string.story10, R.drawable.image10)
        )
    }
}
