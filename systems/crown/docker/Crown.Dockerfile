# Base image
FROM ubuntu:latest

# Set non-interactive mode for apt-get
ENV DEBIAN_FRONTEND=noninteractive

# Update and install core tools
RUN apt-get update && apt-get install -y \
    git \
    curl \
    tar \
    make \
    bc \
    g++ \
    gcc \
    wget \
    software-properties-common \
    gnupg \
    unzip && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Install GNU tools
RUN apt-get update && apt-get install -y \
    time \
    sed \
    gawk \
    getopt && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Install Java (OpenJDK 8)
RUN apt-get update && apt-get install -y \
    openjdk-8-jdk && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Install Hadoop (2.7.0)
RUN wget https://archive.apache.org/dist/hadoop/core/hadoop-2.7.0/hadoop-2.7.0.tar.gz && \
    tar -xvzf hadoop-2.7.0.tar.gz -C /usr/local && \
    mv /usr/local/hadoop-2.7.0 /usr/local/hadoop && \
    rm hadoop-2.7.0.tar.gz

# Install Scala (2.12.15)
RUN wget https://downloads.lightbend.com/scala/2.12.15/scala-2.12.15.tgz && \
    tar -xvzf scala-2.12.15.tgz -C /usr/local && \
    mv /usr/local/scala-2.12.15 /usr/local/scala && \
    rm scala-2.12.15.tgz && \
    ln -s /usr/local/scala/bin/* /usr/local/bin/

# Install .NET (5.0.403)
RUN wget https://packages.microsoft.com/config/ubuntu/$(lsb_release -rs)/packages-microsoft-prod.deb && \
    dpkg -i packages-microsoft-prod.deb && \
    apt-get update && apt-get install -y dotnet-sdk-5.0 && \
    rm packages-microsoft-prod.deb

# Install Maven (3.8.4)
RUN wget https://downloads.apache.org/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.tar.gz && \
    tar -xvzf apache-maven-3.8.4-bin.tar.gz -C /usr/local && \
    mv /usr/local/apache-maven-3.8.4 /usr/local/maven && \
    rm apache-maven-3.8.4-bin.tar.gz && \
    ln -s /usr/local/maven/bin/* /usr/local/bin/

# Install SBT (1.4.3)
RUN echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" > /etc/apt/sources.list.d/sbt.list && \
    curl -sL https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x99e82a75642ac823 > /tmp/sbt-key.gpg && \
    apt-key add /tmp/sbt-key.gpg && \
    apt-get update && apt-get install -y sbt=1.4.3 && \
    rm /tmp/sbt-key.gpg

# Install OCaml (5.0.0)
RUN apt-get update && apt-get install -y opam && \
    opam init -y --disable-sandboxing && \
    opam switch create 5.0.0 && \
    eval $(opam env) && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Install G++ (GCC 11)
RUN apt-get update && apt-get install -y g++-11 gcc-11 && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Install PostgreSQL Client (10.23)
RUN apt-get update && apt-get install -y postgresql-client-10 && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Install Pyenv and Pyenv-Virtualenv
RUN curl https://pyenv.run | bash && \
    echo 'export PATH="/root/.pyenv/bin:$PATH"' >> ~/.bashrc && \
    echo 'eval "$(pyenv init --path)"' >> ~/.bashrc && \
    echo 'eval "$(pyenv init -)"' >> ~/.bashrc && \
    echo 'eval "$(pyenv virtualenv-init -)"' >> ~/.bashrc && \
    source ~/.bashrc && \
    pyenv install 3.10.6 && pyenv virtualenv 3.10.6 myenv

# Install Gnuplot (5.4)
RUN apt-get update && apt-get install -y gnuplot && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Verify installations
RUN java -version && \
    hadoop version && \
    scala -version && \
    dotnet --version && \
    mvn -version && \
    sbt sbtVersion && \
    ocaml --version && \
    g++-11 --version && \
    psql --version && \
    pyenv --version && \
    gnuplot --version

# Set default shell to bash
CMD ["/bin/bash"]
