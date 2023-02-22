package net.cctech.user_service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Can.Ru
 */
@Data
@Entity
@Builder
@Table(name ="cctech_operate_log")
public class OperateLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="event_type")
    private String eventType;

    @Column(name="object")
    private String object;

    @Column(name="result")
    private String result;

    @Column(name="start_time")
    private LocalDateTime startTime;

    @Column(name="end_time")
    private LocalDateTime endTime;
}
