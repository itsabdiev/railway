package com.plenka.railway.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "actions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Action {
        @Id
        @GeneratedValue
        private Integer id;
        @NotBlank
        @Column(nullable = false)
        private String title;
        @Column(nullable = false)
        @NotBlank
        private String description;
        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        private Status status;
        @Column(nullable = false,name = "content_type")
        @Enumerated(EnumType.STRING)
        private Type contentType;
        @Column(nullable = false,name = "created_at")
        private LocalDateTime createdAt;
        @Column(name = "updated_at")
        private LocalDateTime updatedAt;
        private String url;

        public Action(String title, String description, Status status, Type contentType, LocalDateTime createdAt, LocalDateTime updatedAt, String url) {
                this.title = title;
                this.description = description;
                this.status = status;
                this.contentType = contentType;
                this.createdAt = createdAt;
                this.updatedAt = updatedAt;
                this.url = url;
        }


}
