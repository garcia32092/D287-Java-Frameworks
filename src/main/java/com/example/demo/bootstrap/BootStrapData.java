package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        partRepository.deleteAll();
//        productRepository.deleteAll();
//        outsourcedPartRepository.deleteAll();

        if (outsourcedPartRepository.count() == 0 && partRepository.count() == 0) {
            OutsourcedPart eGuitarStrings = new OutsourcedPart();
            eGuitarStrings.setCompanyName("Guitar Center");
            eGuitarStrings.setName("E Guitar Strings");
            eGuitarStrings.setInv(20);
            eGuitarStrings.setPrice(5.99);
            eGuitarStrings.setMaxInv(50);
            eGuitarStrings.setMinInv(5);

            OutsourcedPart aGuitarStrings = new OutsourcedPart();
            aGuitarStrings.setCompanyName("Guitar Center");
            aGuitarStrings.setName("A Guitar Strings");
            aGuitarStrings.setInv(20);
            aGuitarStrings.setPrice(19.99);
            aGuitarStrings.setMaxInv(50);
            aGuitarStrings.setMinInv(5);

            OutsourcedPart guitarAmp = new OutsourcedPart();
            guitarAmp.setCompanyName("Sweetwater");
            guitarAmp.setName("Guitar Amp");
            guitarAmp.setInv(15);
            guitarAmp.setPrice(149.99);
            guitarAmp.setMaxInv(50);
            guitarAmp.setMinInv(5);

            outsourcedPartRepository.save(eGuitarStrings);
            outsourcedPartRepository.save(aGuitarStrings);
            outsourcedPartRepository.save(guitarAmp);

            InhousePart eGuitarBody = new InhousePart();
            eGuitarBody.setName("Electric Guitar Body");
            eGuitarBody.setInv(15);
            eGuitarBody.setPrice(199.99);
            eGuitarBody.setId(1);
            eGuitarBody.setMaxInv(25);
            eGuitarBody.setMinInv(3);

            InhousePart aGuitarBody = new InhousePart();
            aGuitarBody.setName("Acoustic Guitar Body");
            aGuitarBody.setInv(15);
            aGuitarBody.setPrice(199.99);
            aGuitarBody.setId(2);
            aGuitarBody.setMaxInv(25);
            aGuitarBody.setMinInv(3);

            partRepository.save(eGuitarBody);
            partRepository.save(aGuitarBody);
        }

        if (productRepository.count() == 0) {
            Product eGuitar = new Product("Electric Guitar",449.99,12);
            Product aGuitar = new Product("Acoustic Guitar",499.99,12);
            Product strings = new Product("Strings Bundle",25.99,5);
            Product guitarAmp = new Product("Guitar Amp",149.99,3);
            Product eGuitarAndAmp = new Product("Electric Guitar/Amp Bundle",799.99,3);

            productRepository.save(eGuitar);
            productRepository.save(aGuitar);
            productRepository.save(strings);
            productRepository.save(guitarAmp);
            productRepository.save(eGuitarAndAmp);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: " + partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
