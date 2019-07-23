package entities;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BorrowerService {
    private RestTemplate restTemplate=null;
    public BorrowerService()
    {
        this.restTemplate=new RestTemplate();
        MappingJackson2HttpMessageConverter messageConverter=new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(messageConverter);
    }
    public void rentBook(Borrower2 bookname)
    {
        String url="http://localhost:8080/bookrentalsystemAPI/RentBook";
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Borrower2> entity=new HttpEntity<>(bookname,headers);
        ResponseEntity<Borrower2> responseEntity=restTemplate.exchange(url, HttpMethod.POST,entity,Borrower2.class);
    }
    public void returnBook(Borrower2 borrower)
    {
        String url="http://localhost:8080/bookrentalsystemAPI/Returnbook";
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Borrower2> entity=new HttpEntity<>(borrower,headers);
        ResponseEntity<Borrower2> responseEntity=restTemplate.exchange(url, HttpMethod.POST,entity,Borrower2.class);
    }
    public Optional<List<Borrower2>> allBorrowerDetails()
    {
        String url="http://localhost:8080/bookrentalsystemAPI/GetAllBorrowers";
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Borrower2> entity=new HttpEntity<>(headers);
        try {
            ResponseEntity<List<Borrower2>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Borrower2>>() {
            });
            if (responseEntity.getBody()!=null)
            {
                return Optional.of(responseEntity.getBody());
            }
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
