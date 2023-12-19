package phase1;

import model.PatternInfo;
import model.SentimentInfo;
import model.SentimentPercent;
import model.SentimentType;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SentimentReducer extends Reducer<PatternInfo, SentimentInfo, NullWritable, Text> {

    protected void reduce(PatternInfo patternInfo, Iterable<SentimentInfo> values, Reducer<PatternInfo,SentimentInfo,NullWritable,Text>.Context context)
            throws IOException, InterruptedException {

        int totalCount=0;
        Map<SentimentType,Integer> countMap=new HashMap<>();
        for (SentimentInfo value:values){
            countMap.put(value.getSentimentType(),countMap.getOrDefault(value.getSentimentType(),0)+1);
            totalCount+=1;
        }

        System.out.printf(patternInfo.toString() + countMap.toString() + totalCount);

        double negativePercent=0.0;
        double positivePercent=0.0;
        double neutralPercent=0.0;
        for (Map.Entry<SentimentType,Integer> entrySet:countMap.entrySet()){
            if (entrySet.getKey().equals(SentimentType.NEGATIVE)){
                negativePercent=((double) entrySet.getValue() /totalCount)*100;
            }
            else if (entrySet.getKey().equals(SentimentType.POSITIVE)){
                positivePercent=((double) entrySet.getValue() /totalCount)*100;
            }
            else {
                neutralPercent=((double) entrySet.getValue() /totalCount)*100;
            }
        }
        SentimentPercent sentimentPercent=new SentimentPercent(negativePercent,positivePercent,neutralPercent);

        context.write(NullWritable.get(),new Text(patternInfo+","+sentimentPercent));

    }
}
