data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val copyright: String = "",
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val likes: Likes = Likes()
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = false,
    val canPublish: Boolean = false
)

object WallService {
    private val posts = mutableListOf<Post>()
    private var count = 1
    fun add(post: Post): Post {
        val addedPost = post.copy(id = count++)
        posts.add(addedPost)
        return addedPost
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }

        if (index == -1) {
            return false
        }
        posts[index] = post
        return true
    }
    fun clear() {
        posts.clear()
        count = 1
    }
}

fun main() {
    val post = Post(text = "Hello World!", likes = Likes(10, true, true, true))
    val addedPost = WallService.add(post)
    println("До обновления: ${addedPost.text}")

    val updatedPost = Post(addedPost.id, text = "Hello Tanya!")

    val result = WallService.update(updatedPost)

    println("Новый пост обновлен: ${updatedPost.text}")
    println("Лайков: ${addedPost.likes.count}")
}
