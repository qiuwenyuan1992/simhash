package datapark.SimHashSample3;

import org.apache.log4j.Logger;

/**
 * Created by dpliyuan on 2016/2/29.
 */
public class DuplicateRemoversFactory {

    private static Logger log = Logger.getLogger(DuplicateRemoversFactory.class);

    public static DuplicateJudge factory(String removerType) {

        if (removerType.equalsIgnoreCase("simhash")) {

            return new SimHashJudge();

        } else if (removerType.equalsIgnoreCase("es")) {
            //todo:ES Remover
            return null;
        } else {
            log.info("no such type of DuplicateJudge:" + removerType);
            return null;
        }
    }

}
