package specialities.sit;

import student.discipline.Discipline;
import student.discipline.mandatory.English;
import student.discipline.mandatory.OK;
import student.discipline.mandatory.OOP;

import java.util.List;

public class SecondCourse extends SIT{
    public static final List<Discipline> SIT_DISCIPLINES_2 = List.of(new English(), new OK(), new OOP());

    public SecondCourse() {
        super.setDisciplines(SIT_DISCIPLINES_2);
        setGrades();
    }
}
