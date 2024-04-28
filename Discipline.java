package student.discipline;

public abstract class Discipline {
    private int courseNeeded;
    private int earnedGrade;

    public Discipline(int courseNeeded, int earnedGrade) {
        this.courseNeeded = courseNeeded;
        this.earnedGrade = earnedGrade;
    }

    public int getEarnedGrade() {
        return earnedGrade;
    }

    public void setEarnedGrade(int earnedGrade) {
        if(earnedGrade < 2 || earnedGrade > 6){
            throw new IllegalArgumentException("Grade must be between 2 and 6!");
        }
        this.earnedGrade = earnedGrade;
    }

    public String getName(){
        return this.getClass().getSimpleName();
    }
}
