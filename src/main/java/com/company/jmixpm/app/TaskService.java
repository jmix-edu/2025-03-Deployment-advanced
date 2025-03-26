package com.company.jmixpm.app;

import com.company.jmixpm.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.ValueLoadContext;
import io.jmix.core.entity.KeyValueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private DataManager dataManager;

    public User findLeastBusyUser() {
        List<KeyValueEntity> keyValueEntities = dataManager.loadValues(new ValueLoadContext().setQuery(new ValueLoadContext.Query(
                "select u, sum(t.estimatedEfforts) from User u " +
                        "left outer join Task_ t on u = t.assignee " +
                        "group by u order by sum(t.estimatedEfforts)"))
                .addProperty("user")
                .addProperty("efforts"));

        User leastBusy = keyValueEntities.get(0).getValue("user");
        if (leastBusy == null) {
            throw new IllegalStateException();
        }
        return leastBusy;
    }
}
