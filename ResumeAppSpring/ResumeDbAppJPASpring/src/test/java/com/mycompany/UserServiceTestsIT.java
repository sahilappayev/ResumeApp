package com.mycompany;

import com.mycompany.dao.impl.UserDaoImpl;
import com.mycompany.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = UserDaoImpl.class)
@RunWith(SpringRunner.class)
public class UserServiceTestsIT {

    @Autowired
    @Qualifier("userDao1")
    UserDaoImpl userDao;

    @Test
    public void shouldReturnAllUsers_WhenPassedNullParameters() {
        List<User> userList = userDao.getAll(null, null, null);
        assertThat(userList.size()).isEqualTo(4);
    }

    @Test
    public void shouldReturnFilteredUsers_WhenPassedAllParameters(){
        List<User> userList = userDao.getAll("Sahil", "Appayev", 24);

        Assert.assertEquals("Users size must be over than zero", 1, userList.size());

        User u = userList.get(0);

        Assert.assertEquals("Name wrong","Sahil", u.getName());
        Assert.assertEquals("Surname wrong", "Appayev", u.getSurname());
        Assert.assertEquals("Age wrong", 24L, (long)u.getAge());

    }

    @Test
    public void testGivenNullParamsThenGetByEmail(){
        User u = userDao.getByEmail(null);
        Assert.assertEquals("User must be null", null, u);
    }

    @Test
    public void testGivenParamThenGetByEmail(){
        User u = userDao.getByEmail("sahilappayev@gmail.com");
        Assert.assertEquals("Sahil", u.getName());
    }
}
