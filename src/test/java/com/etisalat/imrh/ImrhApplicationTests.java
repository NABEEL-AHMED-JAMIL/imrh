package com.etisalat.imrh;

import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.ProductDto;
import com.etisalat.imrh.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ImrhApplicationTests {

    @Mock
    private ProductRepository productRepository;
    
    @Test
    public void findByProductId() {
        System.out.println(productRepository.findAllProduct());
    }

}
