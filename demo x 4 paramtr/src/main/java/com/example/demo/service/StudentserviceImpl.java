package com.example.demo.service;

import com.example.demo.dto.Studentdto;
import com.example.demo.model.Student;
import com.example.demo.repostery.Studentrepostery;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
        student.setBirthdate(dto.getBirthdate());
        student.setName(dto.getName());
      Student save=repostery.save(student);
      return mapper.map(save,Studentdto.class);
    }
}
