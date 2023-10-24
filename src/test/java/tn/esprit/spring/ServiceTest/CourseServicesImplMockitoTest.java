package tn.esprit.spring.ServiceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.CourseServicesImpl;
import tn.esprit.spring.services.ICourseServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class CourseServicesImplMockitoTest {
    @Mock
    ICourseRepository courseRepository;
    @InjectMocks
    CourseServicesImpl courseServices;

    Course c1 = new Course(2L, 3, TypeCourse.COLLECTIVE_CHILDREN, Support.SNOWBOARD, 40f, 5);


    List<Course> courseList = new ArrayList<Course>(){
        {

        add(new Course(3L,1, TypeCourse.COLLECTIVE_ADULT, Support.SKI, 30f, 2));
        add(new Course(4L,7, TypeCourse.COLLECTIVE_ADULT, Support.SNOWBOARD, 50f, 4));

    }
    };

    @Test
    public void testRetrieveCourse(){
        Mockito.when(courseRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(c1));
        Course course1 = courseServices.retrieveCourse(3L);
        Assertions.assertNotNull(course1);
        System.out.println("3");
        //Assertions.assertEquals(course1.getIdCou(),55L);
    }
    }

