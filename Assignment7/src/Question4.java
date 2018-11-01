import java.util.LinkedList;
import java.util.List;

public class Question4 {
    public List<Interval> merge(List<Interval> intervals) {
        // add your code here
        List<Interval> answer = new LinkedList<>();
        if (intervals == null|| intervals.size() == 0)
            return answer;

        intervals.sort((i1,i2) -> Integer.compare(i1.start,i2.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval period: intervals){
            if (period.start <= end){
                end = Math.max(end,period.end);
            }else {
                answer.add(new Interval(start,end));
                start = period.start;
                end = period.end;
            }
        }
        answer.add(new Interval(start,end));
        return answer;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
