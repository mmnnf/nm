package com.example.demo.service;

import com.example.demo.dto.Studentdto;
import com.example.demo.model.Student;
import com.example.demo.repostery.Studentrepostery;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentserviceImpl implements Studentservice {
    private final Studentrepostery repostery;
    private final ModelMapper mapper;

    @Override
    public Studentdto getStudentbyid(Long id) {
        Student byid = repostery.getById(id);
        Studentdto map = mapper.map(byid, Studentdto.class);  //line2
//        Studentdto a=new Studentdto(); ///evezine yuxaridaki line 2 yazilir
//        a.setAge(byid.getAge());
//        a.setName(byid.getName());
//        a.setId(byid.getId());
        return map;
    }

    @Override
    public Studentdto createStudent(Studentdto dto) {
        Student student=mapper.map(dto,Student.class);
        Student save=repostery.save(student);
        return mapper.map(save,Studentdto.class);
    }

    @Override
    public void deleteStudent(Long id) {
      repostery.deleteById(id);
    }

    @Override
    public Studentdto updateStudent(Studentdto dto) {
        Student student= repostery.findById(dto.getId()).orElseThrow((()->new RuntimeException("student not found")));
        student.setAge(dto.getAge());
        student.setName(dto.getName());
      Student save=repostery.save(student);
      return mapper.map(save,Studentdto.class);
    }

    @Override
    public List<Studentdto> gettt() {
//        Student byid = repostery.getById(id);
//        Studentdto map = mapper.map(byid, Studentdto.class);
        List<Student>mm=new ArrayList<>();
        List<Studentdto>mmdto=new ArrayList<>();;
        try {
              mm= repostery.findAll();
        }
        catch (Exception ex)
        {
            System.out.println("error");
        }
        for (Student i:mm)
        {
            mmdto.add(mapper.map(i,Studentdto.class));
        }

        return mmdto;
    }
}
