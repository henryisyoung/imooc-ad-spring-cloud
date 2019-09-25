package com.imooc.ad.vo;

import com.netflix.discovery.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String username;

    public boolean validate() {
        return !StringUtils.isEmpty(username);
    }
}
