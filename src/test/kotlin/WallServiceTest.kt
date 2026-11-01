import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before // В JUnit 4 это просто @Before, а не @BeforeEach
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val post = Post(text = "Тестовый пост")
        val addedPost = WallService.add(post)
        assertNotEquals(0, addedPost.id)
    }

    @Test
    fun updateReturnsTrue() {
        val post = Post(text = "Тестовый пост")
        val addedPost = WallService.add(post)
        val updatedPost = addedPost.copy(text = "Обновленный пост")
        val result = WallService.update(updatedPost)

        assertTrue(result)
    }

    @Test
    fun updateReturnsFalse() {
        val fakePost = Post(99, text = "Тестовый пост-несуществующий")
        val result = WallService.update(fakePost)

        assertFalse(result)
    }
}