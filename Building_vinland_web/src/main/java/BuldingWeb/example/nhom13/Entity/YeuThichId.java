package BuldingWeb.example.nhom13.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class YeuThichId implements Serializable {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "ma_bds")
    private Integer maBds;

    // Cần
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YeuThichId that = (YeuThichId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(maBds, that.maBds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, maBds);
    }
}