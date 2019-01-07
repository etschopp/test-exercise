package com.github.etschopp.exercise;

import com.github.etschopp.exercise.domain.Report;
import com.github.etschopp.exercise.domain.EmployeeReportData;
import com.github.etschopp.exercise.domain.ReportData;
import com.github.etschopp.exercise.domain.TimeFrame;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


	@Test
    public void returnLCPDayMessage() throws Exception {
		
		
		List<ReportData> reportList = new ArrayList<ReportData> ();
		reportList.add(new ReportData(new TimeFrame("2018-06-01T00:00:00.000Z","2018-06-02T00:00:00.000Z"), 0.24));
		
		Report report = new Report("LCP", "day", reportList);
		
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/reporting?business_id=b2aeb27b-c85c-4ad8-83d4-d9511063d418&report=LCP&timeInterval=day&start=2018-06-01T00:00:00.000Z&end=2018-06-02T00:00:00.000Z",
                Report.class)).isEqualTo(report);
    }
	
	
	@Test
    public void returnFCPDayMessage() throws Exception {
				
		List<ReportData> reportList = new ArrayList<ReportData> ();
		reportList.add(new ReportData(new TimeFrame("2018-06-01T00:00:00.000Z","2018-06-02T00:00:00.000Z"), 0.53));
		
		Report report = new Report("FCP", "day", reportList);
		
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/reporting?business_id=b2aeb27b-c85c-4ad8-83d4-d9511063d418&report=FCP&timeInterval=day&start=2018-06-01T00:00:00.000Z&end=2018-06-02T00:00:00.000Z",
                Report.class)).isEqualTo(report);
    }
	
	@Test
    public void returnEGSDayMessage() throws Exception {
						
		ResponseEntity<String> entity = this.restTemplate.getForEntity("http://localhost:" + port + "/reporting?business_id=b2aeb27b-c85c-4ad8-83d4-d9511063d418&report=EGS&timeInterval=day&start=2018-06-01T00:00:00.000Z&end=2018-06-02T00:00:00.000Z", String.class);
		
        String body = entity.getBody();
		
		String expectedString = "{\"report\":\"EGS\",\"timeInterval\":\"day\",\"data\":[{\"timeFrame\":{\"start\":\"2018-06-01T00:00:00.000Z\",\"end\":\"2018-06-02T00:00:00.000Z\"},\"value\":333.0,\"employee\":\"Jessica Burrey\"},{\"timeFrame\":{\"start\":\"2018-06-01T00:00:00.000Z\",\"end\":\"2018-06-02T00:00:00.000Z\"},\"value\":345.0,\"employee\":\"Shawn Saldana\"},{\"timeFrame\":{\"start\":\"2018-06-01T00:00:00.000Z\",\"end\":\"2018-06-02T00:00:00.000Z\"},\"value\":437.0,\"employee\":\"Kylo Ren\"}]}";
			
		log.debug("EGS body : " + body);
		
		assertThat(body).contains(expectedString);
		       
    }
		
}
