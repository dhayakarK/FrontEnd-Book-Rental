package entities;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookService {
    private RestTemplate restTemplate=null;
    public BookService()
    {
        this.restTemplate=new RestTemplate();
        MappingJackson2HttpMessageConverter messageConverter=new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(messageConverter);

    }

    public void createBook(Book book)
    {
        String url="http://localhost:8080/bookrentalsystemAPI/Addbook";
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Book> entity=new HttpEntity<>(book,headers);

        ResponseEntity<Book> responseEntity=restTemplate.exchange(url,HttpMethod.POST,entity,Book.class);
        try{
            restTemplate.exchange(url,HttpMethod.POST,entity,Book.class);

        } catch(HttpStatusCodeException e){
            String errorpayload = e.getResponseBodyAsString();

            //do whatever you want
        } catch(RestClientException e){
            //no response payload, tell the user sth else
        }

       // new View(Display.getDefault());
    }
    public List<Book> getAll()
    {
        String url="http://localhost:8080/bookrentalsystemAPI/GetAll";
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity=new HttpEntity<>(headers);

        ResponseEntity<List<Book>> responseEntity= restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference< List<Book>>() {
    });
        List<Book> bookList=responseEntity.getBody();
       /* for (Book book: bookList) {
            System.out.println(" "+book.toString());

        }
        System.out.println(" "+responseEntity.getStatusCode());
        System.out.println(" "+responseEntity.getHeaders());*/
        return bookList;
    }
    public Optional<List<Book>> searchByAuthorName(String authorName)
    {
        String url="http://localhost:8080/bookrentalsystemAPI/searchByauthorName/"+authorName;
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity=new HttpEntity<>(headers);
        try {
            ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference< List<Book>>(){});
            if (responseEntity.getBody() != null) {
                return (Optional<List<Book>>) Optional.of(responseEntity.getBody());
            }
        } catch (RestClientException e) {
            return Optional.empty();

        }
        return Optional.empty();
    }
    public Optional<List<Book>> searchByBookName(String bookName)
    {
        String url="http://localhost:8080/bookrentalsystemAPI/searchBybookName/"+bookName;
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity=new HttpEntity<>(headers);
        try {
            ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,  new ParameterizedTypeReference< List<Book>>(){});
            if (responseEntity.getBody()!=null)
            {
                return (Optional<List<Book>>) Optional.of(responseEntity.getBody());
            }
        } catch (RestClientException e) {
             return Optional.empty();
        }
        return Optional.empty();
    }
   /* public void rentBook(Borrower bookname)
    {
        String url="http://localhost:8080/bookrentalsystemAPI/RentBook";
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Borrower> entity=new HttpEntity<>(bookname,headers);
        ResponseEntity<Book> responseEntity=restTemplate.exchange(url,HttpMethod.POST,entity,Book.class);
        System.out.println(responseEntity.toString());
    }*/
   public void deleteBook(String bookName)
   {
       String url="http://localhost:8080/bookrentalsystemAPI/delete/"+bookName;
       HttpHeaders headers=new HttpHeaders();
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       headers.setContentType(MediaType.APPLICATION_JSON);
       HttpEntity<String> entity=new HttpEntity<>(headers);
       ResponseEntity<Book> responseEntity=restTemplate.exchange(url,HttpMethod.DELETE,entity,Book.class);
       /*System.out.println(responseEntity.toString());
       System.out.println(responseEntity.getStatusCode());
       System.out.println(responseEntity.getHeaders());*/
   //    return "book deleted";

   }
}
