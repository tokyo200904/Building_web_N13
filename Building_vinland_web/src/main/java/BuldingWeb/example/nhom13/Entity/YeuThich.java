package BuldingWeb.example.nhom13.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "yeu_thich")
public class YeuThich {

    @EmbeddedId
    private YeuThichId id;

    // --- Relationships ---

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId") // Map 'userId' từ YeuThichId
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maBds") // Map 'maBds' từ YeuThichId
    @JoinColumn(name = "ma_bds")
    private BatDongSan batDongSan;
}