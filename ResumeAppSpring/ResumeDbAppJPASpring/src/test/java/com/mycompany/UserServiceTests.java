package com.mycompany;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.service.impl.UserServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = UserServiceImpl.class)
public class UserServiceTests {

    @Mock
    UserDaoInter userDAO;

    //real obyekt istifade etmekle mueyyen metod ve deyisenleri moklamaq
//    @Spy
//    UserDaoInter userDAO;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeClass
    public static void setUp(){
        System.out.println("setUp() is called");
    }

    @Before
    public void before(){
        System.out.println("before() is called");

        //Mock annotasiyasi altinda olan obyektleri yaradir
        MockitoAnnotations.initMocks(this);

        List<User> users = new ArrayList<>();

        User u = new User();
        u.setName("Sahil");
        u.setSurname("Appayev");
        u.setAge(24);

        users.add(u);

        Mockito.when(userDAO.getAll(null, null,null)).thenReturn(users);
        Mockito.when(userDAO.getAll("Sahil", "Appayev", 24)).thenReturn(users);
        Mockito.when(userDAO.getByEmail("sahilappayev@gmail.com")).thenReturn(u);
        Mockito.when(userDAO.getByEmail(null)).thenReturn(null);
    }

    @Test
    public void shouldReturnAllUsers_WhenPassedNullParameters() {
        List<User> userList = userService.getAll(null, null, null);
        assertThat(userList.size()).isEqualTo(1);

        //metodun heqiqeten cagirilmagini tesdiqleyir
        Mockito.verify(userDAO, Mockito.atLeastOnce())
                .getAll(null, null, null);
    }

    @Test
    public void shouldReturnFilteredUsers_WhenPassedAllParameters(){
        List<User> userList = userService.getAll("Sahil", "Appayev", 24);

        Assert.assertEquals("Users size must be over than zero", 1, userList.size());

        User u = userList.get(0);

        Assert.assertEquals("Name wrong","Sahil", u.getName());
        Assert.assertEquals("Surname wrong", "Appayev", u.getSurname());
        Assert.assertEquals("Age wrong", 24L, (long)u.getAge());


        Mockito.verify(userDAO, Mockito.atLeastOnce())
                .getAll("Sahil", "Appayev", 24);
    }

    @Test
    public void testGivenNullParamsThenGetByEmail(){
        User u = userService.getByEmail(null);
        Assert.assertEquals("User must be null", null, u);

        Mockito.verify(userDAO, Mockito.atLeastOnce())
                .getByEmail(null);
    }

    @Test
    public void testGivenParamThenGetByEmail(){
        User u = userService.getByEmail("sahilappayev@gmail.com");
        Assert.assertEquals("Sahil", u.getName());

        Mockito.verify(userDAO, Mockito.atLeastOnce())
                .getByEmail("sahilappayev@gmail.com");
    }
}
