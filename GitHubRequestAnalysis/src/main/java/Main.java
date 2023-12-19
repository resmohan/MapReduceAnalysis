import java.io.IOException;

import model.AnalysisSentiment;
import model.PatternInfo;
import model.SentimentInfo;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import phase1.SentimentGroupComparator;
import phase1.SentimentMapper;
import phase1.SentimentPartitioner;
import phase1.SentimentReducer;
import phase2.AnalysisGroupComparator;
import phase2.AnalysisMapper;
import phase2.AnalysisPartitioner;
import phase2.AnalysisReducer;
import phase2.AnalysisSortComparator;

public class Main {

    public static void main(String[] args) {
        try{
            Configuration conf1 = new Configuration();
            String[] inputArgs = new GenericOptionsParser(conf1,args).getRemainingArgs();
            if(inputArgs.length < 2){
                System.err.println("Usage: Main <in> <out>");
                System.exit(2);
            }
            Job job1 = Job.getInstance(conf1, "Git request mapper");
            job1.setJarByClass(Main.class);
            job1.setMapperClass(SentimentMapper.class);
            job1.setGroupingComparatorClass(SentimentGroupComparator.class);
            job1.setPartitionerClass(SentimentPartitioner.class);
            job1.setReducerClass(SentimentReducer.class);
            job1.setMapOutputKeyClass(PatternInfo.class);
            job1.setMapOutputValueClass(SentimentInfo.class);
            job1.setOutputKeyClass(NullWritable.class);
            job1.setOutputValueClass(Text.class);
            FileInputFormat.addInputPath(job1, new Path(inputArgs[0]));
            FileOutputFormat.setOutputPath(job1,new Path(inputArgs[1]));

            Configuration conf2 = new Configuration();
            Job job2 = Job.getInstance(conf2, "Git request analyzer");
            job2.setJarByClass(Main.class);
            job2.setMapperClass(AnalysisMapper.class);
            job2.setGroupingComparatorClass(AnalysisGroupComparator.class);
            job2.setSortComparatorClass(AnalysisSortComparator.class);
            job2.setNumReduceTasks(5);
            job2.setPartitionerClass(AnalysisPartitioner.class);
            job2.setReducerClass(AnalysisReducer.class);
            job2.setMapOutputKeyClass(AnalysisSentiment.class);
            job2.setMapOutputValueClass(AnalysisSentiment.class);
            job2.setOutputKeyClass(Text.class);
            job2.setOutputValueClass(Text.class);
            FileInputFormat.addInputPath(job2, new Path(inputArgs[1]));
            FileOutputFormat.setOutputPath(job2,new Path(inputArgs[1]+"finalOutput"));


            if (job1.waitForCompletion(true)) {
                System.exit(job2.waitForCompletion(true) ? 0 : 1);
            } else {
                System.exit(1); // Job1 failed, exit with error code 1
            }
        } catch (IOException | InterruptedException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
