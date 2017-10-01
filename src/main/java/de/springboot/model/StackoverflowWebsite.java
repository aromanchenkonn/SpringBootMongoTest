package de.springboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class StackoverflowWebsite {
    @Id
    private  String id;
    private  String iconImageUrl;
    private  String website;
    private  String title;
    private  String description;
}
