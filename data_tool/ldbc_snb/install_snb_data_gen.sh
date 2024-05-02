#clone repository
SCRIPT_PATH=$(dirname $(readlink -f $0))
SOURCE_PATH="${SCRIPT_PATH}/ldbc_snb_datagen_spark"
SCRIPT="${SOURCE_PATH}/scripts"

if [ -d "${SOURCE_PATH}" ]
then
    echo "Found SNB data gen source at ${SOURCE_PATH} "
else  
    echo "Cloning data source"
    cd "${SCRIPT_PATH}"
    git clone git@github.com:ldbc/ldbc_snb_datagen_spark.git
fi

if [ -d "/opt/spark-3.2.2-bin-hadoop3.2" ]
then
    echo "SPARK 3.2.2 found at /opt/"
else
    bash "${SCRIPT}/ldbc_snb_datagen_spark/scripts/get-spark-to-opt.sh"
fi

if grep -q 'export SPARK_HOME=' "${HOME}/.profile";
then
    source "${HOME}/.profile"
    echo "SPARK_HOME=${SPARK_HOME}"
else     
    echo 'export SPARK_HOME="/opt/spark-3.2.2-bin-hadoop3.2"' >> ${HOME}/.profile
fi     

if grep -q 'export PATH="${SPARK_HOME}/bin:${PATH}"' "${HOME}/.profile"; 
then 
    source "${HOME}/.profile"
    echo "SPARK_PATH=${PATH}"
else
    echo 'export PATH="${SPARK_HOME}/bin:${PATH}"' >> "${HOME}/.profile";
fi
source "${HOME}/.profile"

#rm -r "{$SCRIPT}/target/" 
#bash "{$SCRIPT}/build.sh"