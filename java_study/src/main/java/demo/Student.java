package demo;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/24 16:32
 **/
public class Student implements Study {
    private String name;
    private Double score;
    private Line lin;
    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

    public Line getLin() {
        return lin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setLin(Line lin) {
        this.lin = lin;
    }

    @Override
    public void studyLine() {
        System.out.println("您所选的科目是："+lin.getEmplymentClass()+",应缴纳学费："+lin.getMoney()+"元。");
    }
    void exam(){
        if(score > 60){
            System.out.println("您的成绩为"+score+",考试通过”");
        }else{
            System.out.println("您的成绩为"+score+",考试不通过");
        }
    }

}
